let mainStat = document.getElementById('mainStatSelect');
let subStatArr = Array.from(document.getElementsByClassName('subStatSelect'));

mainStat.addEventListener('change', function () {
    let mainStatValue = mainStat.value;
    if (mainStatValue !== '') {
        subStatArr.forEach(subStat => {
            Array.from(subStat.options).forEach(function (option) {
                option.hidden = option.value === mainStatValue;
            });
        });
    }
});