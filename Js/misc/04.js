function A(val) {
    if(val!==undefined) {
        this.val = val;
    }

    this.say  = function() {
        alert(this.val);
    }
}

A.prototype.val = "PROTO";

new A().say();
new A("sss").say();
