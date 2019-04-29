package sorting

import data.ArrayExamples
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.system.measureTimeMillis

/**
 * Bucket sortFromZeroToOne, or bin sortFromZeroToOne, is a sorting algorithm that works by distributing the elements of an array into
 * a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm or
 * by recursively applying the bucket sorting algorithm.
 */
class BucketSort private constructor() {
	companion object {

		fun testBucketSort() {
			println()
			println("=== Bucket sort ===")
			println("Arr to sort: ${castFromZeroToOne(ArrayExamples.tinyArr)}")

			val tinyArr: ArrayList<Float> = castFromZeroToOne(ArrayExamples.tinyArr)

			val tinyTime = measureTimeMillis {
				sortFromZeroToOne(tinyArr, 5)
			}
			val shortTime = measureTimeMillis {
				sortFromZeroToOne(castFromZeroToOne(ArrayExamples.shortArr), 50)
			}
			val mediumTime = measureTimeMillis {
				sortFromZeroToOne(castFromZeroToOne(ArrayExamples.mediumArr), 500)
			}
			val longTime = measureTimeMillis {
				sortFromZeroToOne(castFromZeroToOne(ArrayExamples.longArr), 5000)
			}
			val hugeTime = measureTimeMillis {
				sortFromZeroToOne(castFromZeroToOne(ArrayExamples.hugeArr), 50000)
			}

			println("Sorted arr: $tinyArr")

			println("Arr of ${ArrayExamples.tinyArr.size} elements was sorted in $tinyTime milliseconds")
			println("Arr of ${ArrayExamples.shortArr.size} elements was sorted in $shortTime milliseconds")
			println("Arr of ${ArrayExamples.mediumArr.size} elements was sorted in $mediumTime milliseconds")
			println("Arr of ${ArrayExamples.longArr.size} elements was sorted in $longTime milliseconds")
			println("Arr of ${ArrayExamples.hugeArr.size} elements was sorted in $hugeTime milliseconds")


			//THIS SECTION WAS MADE BECAUSE TILL NOW BUCKET SORT WAS ALMOST EVERYTIME FASTER THAN QUICK SORT
			val enormousArr = castToPositive(ArrayExamples.enormousArr)
			val enormousTime = measureTimeMillis {
				sortPositive(enormousArr, 1000000) //efficiency largely depends on number of buckets
			}

			//check correctness
			for (i in 0..(enormousArr.size - 2)) {
				if (enormousArr[i] > enormousArr[i + 1]) {
					System.err.println("WRONG ORDER")
				}
			}

			//BUCKET SORT U ARE MY HERO
			println("Arr of ${enormousArr.size} elements was sorted in $enormousTime milliseconds")
		}

		fun sortFromZeroToOne(arr: ArrayList<Float>, bucketsNumber: Int) {
			val buckets = Array<ArrayList<Float>>(bucketsNumber) { ArrayList(0) }

			for (i in 0 until arr.size) {
				buckets[(arr[i] * (bucketsNumber - 1)).roundToInt()].add(arr[i])
			}

			buckets.forEach { InsertionSort.sortFloat(it) }

			var arrIndex = 0
			for (i in 0 until buckets.size) {
				for (j in 0 until buckets[i].size) {
					arr[arrIndex] = buckets[i][j]
					arrIndex++
				}
			}
		}

		fun sortPositive(arr: ArrayList<Float>, bucketsNumber: Int) {
			val buckets = Array<ArrayList<Float>>(bucketsNumber) { ArrayList(0) }
			var max: Int = Int.MIN_VALUE

			for (i in 0 until arr.size) {
				if (arr[i] > max) {
					max = arr[i].roundToInt()
				}
			}

			for (i in 0 until arr.size) {
				buckets[floor(arr[i] / max * (bucketsNumber - 1)).roundToInt()].add(arr[i])
			}

			buckets.forEach { InsertionSort.sortFloat(it) }

			var arrIndex = 0
			for (i in 0 until buckets.size) {
				for (j in 0 until buckets[i].size) {
					arr[arrIndex] = buckets[i][j]
					arrIndex++
				}
			}
		}

		private fun castFromZeroToOne(arr: ArrayList<Int>): ArrayList<Float> {
			val floatArr = ArrayList<Float>(arr.size)

			for (i in 0 until arr.size) {
				floatArr.add(abs(arr[i].toFloat() / 1000))
			}

			return floatArr
		}

		private fun castToPositive(arr: ArrayList<Int>): ArrayList<Float> {
			val floatArr = ArrayList<Float>(arr.size)

			for (i in 0 until arr.size) {
				floatArr.add(abs(arr[i].toFloat()))
			}

			return floatArr
		}
	}
}