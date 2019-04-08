package sorting

import data.ArrayExamples
import kotlin.system.measureTimeMillis

/**
 * Insertion sortFromZeroToOne is a simple sorting algorithm that builds the final sorted array one item at a time
 */
class InsertionSort private constructor() {
	companion object {

		fun testInsertionSort() {
			println()
			println("=== Insertion sortFromZeroToOne ===")
			println("Arr to sortFromZeroToOne: ${ArrayExamples.tinyArr}")

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
			for (i in 0..(arr.size - 1)) {
				val key = arr[i]

				var j = i - 1
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j]
					j--
				}
				arr[j + 1] = key
			}
		}

		fun sortFloat(arr: ArrayList<Float>) {
			for (i in 0..(arr.size - 1)) {
				val key = arr[i]

				var j = i - 1
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j]
					j--
				}
				arr[j + 1] = key
			}
		}
	}
}