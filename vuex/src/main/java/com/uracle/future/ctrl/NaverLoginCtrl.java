package com.uracle.future.ctrl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uracle.future.mapper.MainMapper;
import com.uracle.future.util.AesUtil;
import com.uracle.future.vo.User;

@Controller
public class NaverLoginCtrl {
	@Autowired
	MainMapper dao;
//	ContactDao contactDao;	
//	
//	@Autowired
//	ContactService contactService;
	
	//네이버 로그인에 보낼 상태값 생성
	//생성해서 세션에 담고 암호화 하여 화면으로 보내준다
	@GetMapping("/naver/login")
    @ResponseBody
	public User getNaverState(HttpServletRequest request) throws Exception {
		String rkey = "";
		User user = new User();
		HttpSession session = request.getSession();
		rkey = getRandomState(rkey);
	    // (1) 로그인 완료 후 callback에서 비교하기 위해 세션에 담는다
		System.out.println("rkey(랜덤으로 만듬) = "+rkey);
	    session.setAttribute("RKEY", rkey);
	    
	    // (3) 랜덤 문자열을 AES, BASE64 encode
	    rkey = getEncryptString(rkey);
	    System.out.println("rkey(암호화 된 문자열) = "+rkey);
	    user.setNaverState(rkey);
	    return user;
	}
	
	/**
	 * 네이버 로그인 콜백
	 * @param request
	 * @param code
	 * @param state
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("/naver/login/callback")
	public String naverLoginOk(HttpServletRequest request, 
			@RequestParam(value="code", required=false) String code,
			@RequestParam(value="state", required=false) String state,
			Model model) {
		try {
			HttpSession session = request.getSession();
			String rkey = (String) session.getAttribute("RKEY");
			
			state = URLDecoder.decode(state, "UTF-8");
			state = getDecryptString(state);
			System.out.println("========================콜백==========================");
			System.out.println("rKey = "+rkey);
			System.out.println("state = "+state);
			
			// (1) 전송한 state와 비교하여 같으면 로그인 성공
			if (rkey.equals(state)) {
				//로그인 성공
				System.out.println("로그인 성공");
				getUserInfo(state, code);
				
				model.addAttribute("email", session.getAttribute("EMAIL"));
				model.addAttribute("name", session.getAttribute("NAME"));
				model.addAttribute("birth", session.getAttribute("BIRTH"));
				model.addAttribute("id", session.getAttribute("ID"));
				return "main";
			} else {
				//로그인 실패
				throw new Exception();
//				return "login";
			}
		} catch (Exception e) {
			System.out.println("로그인 오류");
//			model = getLoginPage(request, model);
//			e.printStackTrace();
			return "login";
		}
	}
	
	/**
	 * 로그인 성공한 후 접근토근을 가져온다(접근토큰이 있어여 회원 정보 조회가 가능)
	 * @param state
	 * @param code
	 */
	public void getUserInfo(String state, String code) {
		String param = "client_id=lYOZgJlawAuRoPFLy7ln";
		param += "&client_secret=D5UkpnbmJx";
		param += "&grant_type=authorization_code";
		param += "&state=" + state;
		param += "&code=" + code;
		
		try {
			URL url = new URL("https://nid.naver.com/oauth2.0/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
			conn.setDoOutput(true); 
			conn.setRequestMethod("GET"); 
	//		conn.setRequestProperty("Content-Type", "application/json"); 
			conn.setRequestProperty("Accept-Charset", "UTF-8"); 
	//		conn.setConnectTimeout(10000); 
	//		conn.setReadTimeout(10000); 
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(param);
			wr.flush();
			wr.close();
			int responseCode = conn.getResponseCode();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		
			Map<Object, Object> map = this.getJsonMapData(response.toString());
			this.getNaverUserInfo(map.get("access_token").toString());
			in.close();
			
			System.out.println("HTTP 응답 코드(접근토큰 호출) : " + responseCode);
			System.out.println("HTTP body : " + response.toString());
			
			HttpSession session = this.getRequest().getSession(false);
			System.out.println("rkey : " + (String)session.getAttribute("RKEY"));
			System.out.println("email : " + (String)session.getAttribute("EMAIL"));
			System.out.println("name : " + (String)session.getAttribute("NAME"));
			System.out.println("birth : " + (String)session.getAttribute("BIRTH"));
			System.out.println("id : " + (String)session.getAttribute("ID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getNaverUserInfo(String acc) {
		try {
			URL url = new URL("https://openapi.naver.com/v1/nid/me");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
			conn.setDoOutput(true); 
			conn.setRequestMethod("GET"); 
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty ("Authorization", "Bearer "+acc);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.flush();
			wr.close();
			int responseCode = conn.getResponseCode();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			System.out.println("HTTP 응답 코드(회원정보 호출) : " + responseCode);
			System.out.println("HTTP body : " + response.toString());
			
			Map<Object, Object> resultMap = this.getJsonMapData(response.toString());
			String result = resultMap.get("resultcode").toString();
			
			if (result.equals("00")) {
//				Map<Object, Object> subMap = this.getJsonMapData(resultMap.get("response").toString());
				Map<Object, Object> subMap = (HashMap) resultMap.get("response");
				String eml = subMap.get("email").toString();
				String name = subMap.get("name").toString();
				String birth = subMap.get("birthday").toString();
				String id = subMap.get("id").toString();

				HttpSession session = this.getRequest().getSession();
				session.setAttribute("EMAIL", eml);
				session.setAttribute("NAME", name);
				session.setAttribute("BIRTH", birth);
				session.setAttribute("ID", id);
				
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(eml);
				
				User nUser = dao.getUserInfoByNaverInfo(user); 
				if (nUser != null && nUser.getId() != null) {
					user.setId(nUser.getId());
				}
				
				if (dao.getIdPntCntById(user) == 0) {
					dao.insertIdPnt(user);
				} else {
					dao.updateIdPnt(user);
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<Object, Object> getJsonMapData(String response) {
		Map<Object, Object> map = new HashMap<Object, Object>(); // convert JSON string to Map
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			map = mapper.readValue(response.toString(), new TypeReference<Map<Object, Object>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	public HttpServletRequest getRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }
	
	/**
	 * 네아로에 전달할 state 생성
	 * 
	 * 
	 * @param orgString
	 * @return
	 */
	public String getRandomState(String orgString) {
		SecureRandom random = new SecureRandom();
		String rkey = "";
		
		// (1) 랜덤한 32자리 문자열 만들기
	    for (int i=0; i<32; i++)
	    	rkey += random.nextInt(10);

	    return rkey;
	}
	
	/**
	 * 내부용 토큰 암호화
	 * @param rkey : 생성된 토큰 평문
	 * @return encString : 암호화 된 토큰
	 */
	public String getEncryptString(String rkey) {
		AesUtil aesUtil = new AesUtil();
        
        String encString = "";
		try {
			encString = aesUtil.encrypt(rkey);
			System.out.println("encString : " + encString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        String decString = aesUtil.decrypt(encString);
//        System.out.println("decString : " + decString);
        
        return encString;
	}
	
	/**
	 * 내부용 토큰 복호화
	 * 
	 * 로그인 성공하고 돌려받은 state가 내부에서 발행한 state와 같은지 비교하기 위해 복호
	 * 네이버 로그인 페이지를 호출할때 내부에서 state(32자리 문자열)를 발행해서 보내고 로그인 성공시 응답 파라미터에 포함되어 온다
	 * 
	 * 
	 * @param rkey : 암호화 된 토큰
	 * @return encString : 생성된 토큰 평문
	 */
	public String getDecryptString(String rkey) {
		rkey = rkey.replace(' ', '+');
		System.out.println("입력값 확인 : " + rkey);
		AesUtil aesUtil = new AesUtil();
        
        String decString = "";
		try {
	        decString = aesUtil.decrypt(rkey);
	        System.out.println("decString : " + decString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return decString;
	}
}
