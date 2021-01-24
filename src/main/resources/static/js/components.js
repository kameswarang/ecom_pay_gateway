Vue.component("book-card", {
	props: ['book', 'bookimage', 'incart'],
	template: '<div class="row align-items-center border rounded p-1 m-2"><div class="col-1"><img :src="bookimage" height="70" width="70" class="mx-1"></div><div class="col"><h4 class="d-inline">{{ book.title }}</h4><h5 class="">by {{ book.authors }}</h5>INR {{ book.price }}</div><div class="col-2"><button type="button" class="btn btn-primary float-right" v-if="incart == \'false\'" v-on:click="$emit(\'cart-click\', book)">Add to cart</button></div></div>'
})