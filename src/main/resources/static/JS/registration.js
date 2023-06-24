$('body').on('input', '.input-words', function () { //only-number
    this.value = this.value.replace(/[^a-zа-яё\s]/gi, '');
});

$('body').on('input', '.input-range', function () { //number-range
    var value = this.value.replace(/[^0-9]/g, '');
    if (value < $(this).data('min')) {
        this.value = $(this).data('min');
    } else if (value > $(this).data('max')) {
        this.value = $(this).data('max');
    } else {
        this.value = value;
    }
});

$('body').on('input', '.input-en', function () { //English
    this.value = this.value.replace(/[^a-z\s]/gi, '');
});

$('body').on('input', '.input-ru', function () { //Russian
    this.value = this.value.replace(/[^а-яё\s]/gi, '');
});

$('body').on('input', '.input-surname', function (e) { //First-big-text
    if (e.originalEvent.inputType == 'deleteContentBackward') {
        this.value = '';
    } else {
        value = this.value;
        if (value.replace(/[^0-9]/g, '').length == 1) {
            this.value = '';
        } else {
            value = value.replace(/[^a-zа-яё]/gi, '').substr(-1, 1);
            if (value.length != 0) {
                this.value = value.toUpperCase() + '.';
            } else {
                this.value = '';
            }
        }
    }
});

