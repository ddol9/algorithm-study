/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let buyPrice = prices[0], maxVal = 0;
    for (let i = 1; i < prices.length; i++) {
        if (buyPrice > prices[i]) {
            buyPrice = prices[i];
        } else if (prices[i]-buyPrice > maxVal) {
            maxVal = prices[i]-buyPrice;
        }
    }
    return maxVal
};