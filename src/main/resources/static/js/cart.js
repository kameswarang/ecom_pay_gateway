Vue.config.devtools = true

var mainContent = new Vue({
	el: "#mainContent",
	data: {
		books: JSON.parse(Cookies.get("cart")),
		bookImages: []
	},
	methods: {
		getCartValue: function() {
			var value=0;
			mainContent.books.forEach(function (book){
				value += book.price;
			})
			
			return value;
		}
	}
});

axios.get('/api/bookImages')
	.then(function(response) {
		mainContent.bookImages = response.data;
		
})