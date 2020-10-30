const commonMethod = {
  // The install method will be called with the Vue constructor as the first argument, along with possible options
  install (Vue, options) {
    //ES6 way of const job = options.job
    //const { job } = options
    
    // Add $plugin instance method directly to Vue components
    //Vue.prototype.$myInfo = (name, age) => info(name, age, job)
      
    // Add $surname instance property directly to Vue components
    //Vue.prototype.$surname = 'Smith'

    Vue.prototype.$noti_warn = (text) => {
      Vue.prototype.$notify({
      	group: 'common',
        /*title: 'Validation warnning',*/
        text: text,
        type: 'warn'
      });
    }

    Vue.prototype.$noti_succ = (text) => {
      Vue.prototype.$notify({
      	group: 'common',
        /*title: 'Validation warnning',*/
        text: text,
        type: 'success'
      });
    }

    Vue.prototype.$noti_info = (text) => {
      Vue.prototype.$notify({
      	group: 'common',
        /*title: 'Validation warnning',*/
        text: text,
        type: 'info'
      });
    }
  }
}

export default commonMethod;