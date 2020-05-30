/*
* We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
* (Here, the distance between two points on a plane is the Euclidean distance.)
* You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
* Example 1:
    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
        The distance between (1, 3) and the origin is sqrt(10).
        The distance between (-2, 2) and the origin is sqrt(8).
        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
* Example 2:
    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]
    (The answer [[-2,4],[3,3]] would also be accepted.)
*
* Approach: Apply quicksort with comparison parameter as distance square value.
* 
* */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (K == points.length) {
            return points;
        }
        int len = points.length;
        int left = 0;
        int right = len - 1;

        while(left <= right){
            int partitionIndex = partition(points,left,right);
            if(partitionIndex == K){
                break;
            }
            if(partitionIndex < K){
                left = partitionIndex + 1;
            }else{
                right = partitionIndex - 1;
            }
        }

        return Arrays.copyOfRange(points,0,K);
    }

    public int partition(int[][] points,int left,int right){
        int[] pivot = points[left];

        while(left < right){
            while(left < right && compare(points[right],pivot) <= 0) right--;
            points[left] = points[right];
            while(left < right && compare(points[left],pivot) >= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;

        return left;
    }

    public int compare(int[] point1,int[] point2){
        return (point2[1] * point2[1] + point2[0] * point2[0]) - point1[1] * point1[1] - point1[0] * point1[0];
    }
}
