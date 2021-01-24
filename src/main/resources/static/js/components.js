Vue.component("book-card", {
	props: ['book', 'bookimage'],
	template: '<div class="border rounded p-1 m-2"><img :src="bookimage" height="100" width="100"><h4 class="d-inline">{{ book.title }}</h4><h5 class="d-inline">by {{ book.authors }}</h5></div>'
})