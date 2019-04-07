package examples

class ArrayExamples private constructor() {
	companion object {
		private val tinyArray = List(10) { (-1000..1000).random() }
		private val shortArray = List(100) { (-1000..1000).random() }
		private val mediumArray = List(1000) { (-1000..1000).random() }
		private val longArray = List(10000) { (-1000..1000).random() }
		private val hugeArray = List(100000) { (-1000..1000).random() }

		val tinyArr: ArrayList<Int>
			get() = ArrayList(tinyArray)

		val shortArr: ArrayList<Int>
			get() = ArrayList(shortArray)

		val mediumArr: ArrayList<Int>
			get() = ArrayList(mediumArray)

		val longArr: ArrayList<Int>
			get() = ArrayList(longArray)

		val hugeArr: ArrayList<Int>
			get() = ArrayList(hugeArray)
	}
}