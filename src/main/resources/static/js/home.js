Vue.config.devtools = true

var mainContent = new Vue({
	el: "#mainContent",
	data: {
		books: [],
		bookImages: [],
		cart: []
	},
	methods: {
		doCart: function(book) {
			cart = Cookies.get("cart")
			if(cart == undefined) {
				var cart = [book]
				Cookies.set("cart", JSON.stringify(cart));
			}
			else {
				cart = JSON.parse(cart);
				cart.push(book);
				Cookies.set("cart", JSON.stringify(cart));
			}
			console.log(JSON.parse(Cookies.get("cart")));
			navigation.updateCartNos();
		}
	}
})

axios.get('/api/books')
	.then(function(response){
		mainContent.books = response.data.content;
	})
axios.get('/api/bookImages')
	.then(function(response) {
		mainContent.bookImages = response.data;
		
	})