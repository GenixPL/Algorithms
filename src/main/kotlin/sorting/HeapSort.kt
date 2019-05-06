package sorting

import data.ArrayExamples
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.system.measureTimeMillis

/**
 *  Heap Sort divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by
 *  extracting the largest element and moving that to the sorted region.
 *
 *  Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation
 *  is space efficient. If the parent node is stored at index i, the left child can be calculated by 2 * i + 1 and right
 *  child by 2 * i + 2 (assuming the indexing starts at 0).
 */
class HeapSort private constructor() {
	companion object {

		fun testHeapSort() {
			println()
			println("=== Heap sort ===")
			println("Arr to sort: ${ArrayExamples.tinyArr}")

			val tinyArr: ArrayList<Int> = ArrayExamples.tinyArr

			val tinyTime = measureTimeMillis {
				sort(tinyArr)
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

			println("Sorted arr: $tinyArr")

			println("Arr of ${ArrayExamples.tinyArr.size} elements was sorted in $tinyTime milliseconds")
			println("Arr of ${ArrayExamples.shortArr.size} elements was sorted in $shortTime milliseconds")
			println("Arr of ${ArrayExamples.mediumArr.size} elements was sorted in $mediumTime milliseconds")
			println("Arr of ${ArrayExamples.longArr.size} elements was sorted in $longTime milliseconds")
			println("Arr of ${ArrayExamples.hugeArr.size} elements was sorted in $hugeTime milliseconds")
		}

		fun sort(arr: ArrayList<Int>) {
			val n = arr.size

			// Build heap (rearrange array)
			for (i in (n / 2 - 1) downTo 0) {
				heapify(arr, n, i)
			}

			// One by one extract an element from heap
			for (i in (n - 1) downTo 0) {
				// Move current root to end
				val temp = arr[0]
				arr[0] = arr[i]
				arr[i] = temp

				// call max heapify on the reduced heap
				heapify(arr, i, 0)
			}
		}

		fun heapify(arr: ArrayList<Int>, n: Int, i: Int) {
			var largest = i //init largest as root
			val left = (2 * i) + 1 //left child
			val right = (2 * i) + 2 //right child

			//mark the largest element
			if (left < n && arr[left] > arr[largest]) {
				largest = left
			}
			if (right < n && arr[right] > arr[largest]) {
				largest = right
			}

			// If largest is not root
			if (largest != i) {
				val temp = arr[i]
				arr[i] = arr[largest]
				arr[largest] = temp

				//recursively heapify the affected sub-tree
				heapify(arr, n, largest)
			}
		}
	}
}