Vue.config.devtools = true

var mainContent = new Vue({
	el: "#mainContent",
	data: {
	},
	methods: {
		clearCart: function() {
			Cookies.set("cart", JSON.stringify([]));
			window.location = "home";
		}
	}
});