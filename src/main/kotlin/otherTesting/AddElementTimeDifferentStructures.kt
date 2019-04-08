package otherTesting

import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.measureNanoTime

fun testAddingElementTime() {
	println("=== Test Adding New Elements To Different Structures ===")

	var arr = IntArray(1)
	var mutable = ArrayList<Int>(0)

	val arrTime = measureNanoTime {
		var temp = IntArray(0)
		for (i in 1..1000) {
			var new = IntArray(i)
			for (j in 0..(temp.size - 1)) {
				new[j] = temp[j]
			}
			new[i - 1] = i
			temp = new
		}
		arr = temp
	}

	val mutableTime = measureNanoTime {
		for (i in 0..999) {
			mutable.add(i)
		}
	}

	println("arrTime = ${arrTime}, arr = ${Arrays.toString(arr)}")
	println("mutableTime = ${mutableTime}, arr = ${mutable}")
}