function A() {
    this.say  = function() {
        return "A";
    }
}

A.prototype.say = function() {return "PROTO"};

alert(new A().say());


//VS....

function A() {

}

A.prototype.say = function() {return "PROTO"};

alert(new A().say());
