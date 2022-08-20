const intro = document.getElementById('story1')
const chap1 = document.getElementById('story2')
const chap2 = document.getElementById('story3')

function hindAll() {
    intro.style.display ='none';
    chap1.style.display ='none';
    chap2.style.display ='none';
}

function switchIntro() {
    hindAll();
    return intro.style.display ='block';
}

function switchChap1() {
    hindAll();
    return chap1.style.display ='block';
}

function switchChap2() {
    hindAll();
    return chap2.style.display ='block';
}


