$.noConflict();

Vue.config.devtools = true

var vm = new Vue({
	el: "#mainContent",
	data: {
		books: [],
		bookImages: []
	}
})

axios.get('/api/books')
	.then(function(response){
		vm.books = response.data.content;
	})
axios.get('/api/bookImages')
	.then(function(response) {
		vm.bookImages = response.data;
		
	})