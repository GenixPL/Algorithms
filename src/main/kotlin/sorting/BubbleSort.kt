package sorting

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * Bubble Sort works by repeatedly swapping the adjacent elements if they are in wrong order.
 *
 * It can be optimized by stopping the algorithm if inner loop did not cause any swap.
 */
class BubbleSort private constructor() {
	companion object {
		private val tinyArr = List(10) { (0..1000).random() }.toIntArray()
		private val shortArr = List(100) { (0..1000).random() }.toIntArray()
		private val mediumArr = List(1000) { (0..1000).random() }.toIntArray()
		private val longArr = List(10000) { (0..1000).random() }.toIntArray()
		private val hugeArr = List(100000) { (0..1000).random() }.toIntArray()

		private fun sort(arr: IntArray): IntArray {
			val len = arr.size

			for (i in 0..(len - 2)) { //iterate from 0 to len - 2 (last point [7] id only checked from [6])
				for (j in 0..(len - i - 2)) { //iterate from 0 to last unsorted point (len - i - 2)
					if (arr[j] > arr[j + 1]) { //if next point is smaller than current, then switch them
						val temp = arr[j]
						arr[j] = arr[j + 1]
						arr[j + 1] = temp
					}
				}
			}

			return arr
		}

		fun testBubbleSort() {
			println()
			println("=== Bubble sort ===")
			println("Arr to sort: ${Arrays.toString(tinyArr)}")

			var sorted: IntArray? = null

			val tinyTime = measureTimeMillis {
				sorted = sort(tinyArr)
			}
			val shortTime = measureTimeMillis {
				sort(shortArr)
			}
			val mediumTime = measureTimeMillis {
				sort(mediumArr)
			}
			val longTime = measureTimeMillis {
				sort(longArr)
			}
			val hugeTime = measureTimeMillis {
				sort(hugeArr)
			}

			println("Sorted arr: ${Arrays.toString(sorted)}")

			println("Arr of ${tinyArr.size} elements was sorted in $tinyTime milliseconds")
			println("Arr of ${shortArr.size} elements was sorted in $shortTime milliseconds")
			println("Arr of ${mediumArr.size} elements was sorted in $mediumTime milliseconds")
			println("Arr of ${longArr.size} elements was sorted in $longTime milliseconds")
			println("Arr of ${hugeArr.size} elements was sorted in $hugeTime milliseconds")

		}
	}
}