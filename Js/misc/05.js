function Root() { }
Root.prototype.say = function() {
    return "ROOT";
}

function SubClass() { }

SubClass.prototype = new Root();

alert(new SubClass().say());
