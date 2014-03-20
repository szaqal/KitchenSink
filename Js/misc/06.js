function Root() { }
Root.prototype.say = function() {
    return "ROOT";
}

function SubClass() { }

SubClass.prototype = Object.create(Root.prototype);

alert(new SubClass().say());
