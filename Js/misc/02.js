function A() {
    this.msg = "A";
}

A.prototype.msg = "PROTO";

alert(new A().msg);

//VS...

function A() {
}

A.prototype.msg = "PROTO";

alert(new A().msg);
