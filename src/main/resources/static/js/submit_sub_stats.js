function submit_sub_stats() {
    let dataMap = {};

    let selectFragments =
        document.querySelectorAll('.subStatForm');

    selectFragments.forEach(function(fragment, index) {
        let selectElement =
            fragment.querySelector('.subStatSelect');
        let selectedOption =
            selectElement.options[selectElement.selectedIndex].value;
        let inputFieldValue =
            fragment.querySelector('.subStatValue').value;

        dataMap[selectedOption] = inputFieldValue;

        document.getElementById('dataMapHidden').value =
            JSON.stringify(dataMap);

        document.getElementById('addArtifactForm').submit();
        }
    )



}