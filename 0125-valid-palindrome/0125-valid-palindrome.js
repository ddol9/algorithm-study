/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let newString = s.replace(/[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/ ]/gim, "");
    newString = newString.toUpperCase();
    for (let i = 0; i < 0.5*newString.length; i++) {
        if (newString[i] != newString[newString.length-1-i]) {
            return false
            break
        }
    }
    return true
};