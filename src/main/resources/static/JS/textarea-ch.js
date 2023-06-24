function auto_grow(element) {
    element.style.height = 0;
    element.style.height = (element.scrollHeight) + "px";
}

//auto-height of textarea
var tx = document.getElementsByTagName('textarea');

for (var i = 0; i < tx.length; i++) {

    tx[i].setAttribute('style', 'height:' + (tx[i].scrollHeight) + 'px;overflow-y:hidden;');

    tx[i].addEventListener("input", OnInput, false);

}

function OnInput() {

    this.style.height = 'auto';

    this.style.height = (this.scrollHeight) + 'px';

}


