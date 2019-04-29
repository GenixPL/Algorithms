package sorting

import data.ArrayExamples
import kotlin.collections.ArrayList
import kotlin.system.measureTimeMillis

/**
 * Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves,
 * calls itself for the two halves and then merges the two sorted halves.
 */
class MergeSort private constructor() {
	companion object {

		fun testMergeSort() {
			println()
			println("=== Merge sort ===")
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

		fun sort(arr: ArrayList<Int>): ArrayList<Int> {
			val len = arr.size

			if (len == 1) { //there is nothing more to divide
				return arr
			}

			val midPoint: Int = len / 2
			var leftPart: ArrayList<Int> = ArrayList(arr.subList(0, midPoint))
			var rightPart: ArrayList<Int> = ArrayList(arr.subList(midPoint, len))
			leftPart = sort(leftPart)
			rightPart = sort(rightPart)

			return merge(leftPart, rightPart)
		}

		private fun merge(leftPart: ArrayList<Int>, rightPart: ArrayList<Int>): ArrayList<Int> {
			val merged = ArrayList<Int>(leftPart.size + rightPart.size)

			while (leftPart.isNotEmpty() && rightPart.isNotEmpty()) {
				if (leftPart[0] < rightPart[0]) {
					merged.add(leftPart[0])
					leftPart.removeAt(0)

				} else {
					merged.add(rightPart[0])
					rightPart.removeAt(0)
				}
			}

			while (leftPart.isNotEmpty()) {
				merged.add(leftPart[0])
				leftPart.removeAt(0)
			}

			while (rightPart.isNotEmpty()) {
				merged.add(rightPart[0])
				rightPart.removeAt(0)
			}

			return merged
		}
	}
}