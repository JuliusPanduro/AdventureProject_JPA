function isWithAdult() {
    let yes = "ja";
    let no = "nej";
    if (document.getElementById("yesOrNo").checked) {
        document.getElementById("yesOrNo").value = yes;
    } else {
        document.getElementById("yesOrNo").value = no;
    }
}