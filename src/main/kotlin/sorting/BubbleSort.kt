package sorting

import examples.ArrayExamples
import kotlin.collections.ArrayList
import kotlin.system.measureTimeMillis

/**
 * Bubble Sort works by repeatedly swapping the adjacent elements if they are in wrong order.
 */
class BubbleSort private constructor() {
	companion object {

		fun sort(arr: ArrayList<Int>): ArrayList<Int> {
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
			println("Arr to sort: ${ArrayExamples.tinyArr}")

			var sorted: ArrayList<Int>? = null

			val tinyTime = measureTimeMillis {
				sorted = sort(ArrayExamples.tinyArr)
			}
			val shortTime = measureTimeMillis {
				sort(ArrayExamples.shortArr)
			}
			val mediumTime = measureTimeMillis {
				sort(ArrayExamples.mediumArr)
			}
			val longTime = measureTimeMillis {
				sort(ArrayExamples.longArr)
			}
			val hugeTime = measureTimeMillis {
				sort(ArrayExamples.hugeArr)
			}

			println("Sorted arr: $sorted")

			println("Arr of ${ArrayExamples.tinyArr.size} elements was sorted in $tinyTime milliseconds")
			println("Arr of ${ArrayExamples.shortArr.size} elements was sorted in $shortTime milliseconds")
			println("Arr of ${ArrayExamples.mediumArr.size} elements was sorted in $mediumTime milliseconds")
			println("Arr of ${ArrayExamples.longArr.size} elements was sorted in $longTime milliseconds")
			println("Arr of ${ArrayExamples.hugeArr.size} elements was sorted in $hugeTime milliseconds")

		}
	}
}