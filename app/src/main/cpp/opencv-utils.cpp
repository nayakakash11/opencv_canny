#include <opencv2/imgproc.hpp>
#include "opencv-utils.h"

void edgeDetection(Mat &image) {
    Mat gray, edges;
    cvtColor(image, gray, COLOR_BGR2GRAY);
    Canny(gray, edges, 100, 200);
    cvtColor(edges, image, COLOR_GRAY2BGR);
}