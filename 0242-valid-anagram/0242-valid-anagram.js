/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let letter1={}, letter2 = {};
    if (s.length != t.length) { return false; }
    for (let letter of s) {
        if (letter1[letter] === undefined) { letter1[letter] = 1; }
        else { letter1[letter] += 1; }
    }
    for (let letter of t) {
        if (letter2[letter] === undefined) { letter2[letter] = 1; }
        else { letter2[letter] += 1; }
    }
    
    for (let key in letter1) {
        if (letter1[key] !== letter2[key]) {
            return false;
        }
    }
    return true;
};