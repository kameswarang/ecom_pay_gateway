var navigation = new Vue({
	el: "#navigation",
	data: {
		cartNos: JSON.parse(Cookies.get("cart")).length
	},
	methods: {
		updateCartNos: function() { this.cartNos = JSON.parse(Cookies.get("cart")).length }
	}
})