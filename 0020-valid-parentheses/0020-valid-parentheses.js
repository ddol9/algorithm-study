/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let bracketMap = {
        "(" : ")",
        "[" : "]",
        "{" : "}",
    }
    
    let stack = []
    for (i=0; i<s.length; i++) {
        if (s[i] in bracketMap) {
            stack.push(s[i]);
        } else {
            if (stack.length === 0) {
                return false;
            } else {
                let open = stack.pop();
                if (bracketMap[open] !== s[i]) { return false }
            }
        }
    }
    return stack.length===0;
};