package otherTesting

import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.measureNanoTime

fun testSortTime() {
	println("=== Test Time Needed To Sort Different Structures ===")

	var arr = IntArray(1000)
	var mutable = ArrayList<Int>(1000)

	for (i in 0..999) {
		arr[i] = 1000 - i
		mutable.add(1000 - i)
	}

	val arrTime = measureNanoTime {
		for (i in 0..9) {
			sortArray(arr)
		}
	}

	val mutableTime = measureNanoTime {
		for (i in 0..9) {
			sortArrayList(mutable)
		}
	}

	println("arrTime = ${arrTime}, arr = ${Arrays.toString(arr)}")
	println("mutableTime = ${mutableTime}, arr = ${mutable}")
}

private fun sortArray(arr: IntArray) {
	val len = arr.size

	for (i in 0..(len - 2)) {
		for (j in 0..(len - i - 2)) {
			if (arr[j] > arr[j + 1]) {
				val temp = arr[j]
				arr[j] = arr[j + 1]
				arr[j + 1] = temp
			}
		}
	}
}

private fun sortArrayList(arr: ArrayList<Int>) {
	val len = arr.size

	for (i in 0..(len - 2)) {
		for (j in 0..(len - i - 2)) {
			if (arr[j] > arr[j + 1]) {
				val temp = arr[j]
				arr[j] = arr[j + 1]
				arr[j + 1] = temp
			}
		}
	}
}