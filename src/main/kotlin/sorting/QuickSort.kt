package sorting

import data.ArrayExamples
import kotlin.system.measureTimeMillis

/**
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given
 * array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
 * The key process in quickSort is partition. Target of partitions is, given an array and an element x of array
 * as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x,
 * and put all greater elements after x.
 */
class QuickSort private constructor() {
	companion object {

		fun testQuickSort() {
			println()
			println("=== Quick sortFromZeroToOne ===")
			println("Arr to sortFromZeroToOne: ${ArrayExamples.tinyArr}")

			val tinyArr: ArrayList<Int> = ArrayExamples.tinyArr

			val tinyTime = measureTimeMillis {
				sort(tinyArr, 0, ArrayExamples.tinyArr.size - 1)
			}
			val shortTime = measureTimeMillis {
				sort(ArrayExamples.shortArr, 0, ArrayExamples.shortArr.size - 1)
			}
			val mediumTime = measureTimeMillis {
				sort(ArrayExamples.mediumArr, 0, ArrayExamples.mediumArr.size - 1)
			}
			val longTime = measureTimeMillis {
				sort(ArrayExamples.longArr, 0, ArrayExamples.longArr.size - 1)
			}
			val hugeTime = measureTimeMillis {
				sort(ArrayExamples.hugeArr, 0, ArrayExamples.hugeArr.size - 1)
			}
			val enormousTime = measureTimeMillis {
//				sort(ArrayExamples.enormousArr, 0, ArrayExamples.enormousArr.size - 1)
			}

			println("Sorted arr: $tinyArr")

			println("Arr of ${ArrayExamples.tinyArr.size} elements was sorted in $tinyTime milliseconds")
			println("Arr of ${ArrayExamples.shortArr.size} elements was sorted in $shortTime milliseconds")
			println("Arr of ${ArrayExamples.mediumArr.size} elements was sorted in $mediumTime milliseconds")
			println("Arr of ${ArrayExamples.longArr.size} elements was sorted in $longTime milliseconds")
			println("Arr of ${ArrayExamples.hugeArr.size} elements was sorted in $hugeTime milliseconds")
//			println("Arr of ${ArrayExamples.enormousArr.size} elements was sorted in $enormousTime milliseconds")

		}

		fun sort(arr: ArrayList<Int>, leftIndex: Int, rightIndex: Int) {
			if (leftIndex < rightIndex) {
				val partitionIndex = partition(arr, leftIndex, rightIndex)

				sort(arr, leftIndex, partitionIndex - 1)
				sort(arr, partitionIndex, rightIndex)
			}
		}

		/**
		 *  This function takes last element as pivot, places the pivot element at its correct position in sorted array,
		 *  and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
		 */
		private fun partition(arr: ArrayList<Int>, leftIndex: Int, rightIndex: Int): Int {
			val pivot = arr[rightIndex]

			var i = leftIndex - 1
			for (j in leftIndex..(rightIndex - 1)) {
				if (arr[j] <= pivot) {
					i++

					val temp = arr[i]
					arr[i] = arr[j]
					arr[j] = temp
				}
			}

			val temp = arr[i + 1]
			arr[i + 1] = arr[rightIndex]
			arr[rightIndex] = temp

			return i + 1
		}
	}
}