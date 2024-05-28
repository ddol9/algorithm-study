/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, color) {
    const targetColor = image[sr][sc]
    
    if (targetColor === color) {
        return image;
    }
    
    function floodFill(r, c) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] !== targetColor) {
            return;
        }
        image[r][c] = color; 
        floodFill(r+1, c);
        floodFill(r, c+1);
        floodFill(r-1, c);
        floodFill(r, c-1);
    }
    floodFill(sr, sc)
    return image;
};