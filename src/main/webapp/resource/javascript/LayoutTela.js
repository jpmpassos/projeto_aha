function transicaoTelaJsf(xhr, status, args, fecharL) {
    if (args.tipo === 1) {
        var fecharJanela = args.fecharJanela.split(",");
        var abrirJanela = args.abrirJanela.split(",");
        desktop = $(window).width() > 600;
        for (var i = 0; i < fecharJanela.length; i++) {
            if (fecharJanela[i] !== '') {
                sub = fecharJanela[i].substring(0, 1);
                if (sub === '_') {
                    if (!desktop) {
                        doc = document.getElementById(fecharJanela[i].substring(1, fecharJanela[i].length));
                        doc.style.display = 'none';
                    }
                } else if (sub === '-') {
                    if (desktop) {
                        doc = document.getElementById(fecharJanela[i].substring(1, fecharJanela[i].length));
                        doc.style.display = 'none';
                    }
                } else {
                    doc = document.getElementById(fecharJanela[i]);
                    doc.style.display = 'none';
                }
            }
        }

        for (var i = 0; i < abrirJanela.length; i++) {
            if (abrirJanela[i] !== '') {
                sub = abrirJanela[i].substring(0, 1);
                if (sub === '_') {
                    if (!desktop) {
                        doc = document.getElementById(abrirJanela[i].substring(1, abrirJanela[i].length));
                        doc.style.display = 'block';
                    }
                } else if (sub === '-') {
                    if (desktop) {
                        doc = document.getElementById(abrirJanela[i].substring(1, abrirJanela[i].length));
                        doc.style.display = 'block';
                    }
                } else {
                    doc = document.getElementById(abrirJanela[i]);
                    doc.style.display = 'block';
                }
            }
        }
    }

    if (!fecharL){
        fecharLoading();
    }
}

function abrirLoading() {
    doc = document.getElementById('carregando');
    doc.style.display = 'block';
}

function fecharLoading() {
    doc = document.getElementById('carregando');
    doc.style.display = 'none';
}

function transicaoTela(pFecharJanela, pAbriJanela, reset) {
    var fecharJanela = pFecharJanela.split(",");
    var abrirJanela = pAbriJanela.split(",");
    desktop = $(window).width() > 600;
    for (var i = 0; i < fecharJanela.length; i++) {
        sub = fecharJanela[i].substring(0, 1);
        if (sub === '_') {
            if (!desktop) {
                doc = document.getElementById(fecharJanela[i].substring(1, fecharJanela[i].length));
                doc.style.display = 'none';
            }
        } else if (sub === '-') {
            if (desktop) {
                doc = document.getElementById(fecharJanela[i].substring(1, fecharJanela[i].length));
                doc.style.display = 'none';
            }
        } else {
            doc = document.getElementById(fecharJanela[i]);
            doc.style.display = 'none';
        }
    }

    for (var i = 0; i < abrirJanela.length; i++) {
        sub = abrirJanela[i].substring(0, 1);
        if (sub === '_') {
            if (!desktop) {
                doc = document.getElementById(abrirJanela[i].substring(1, abrirJanela[i].length));
                doc.style.display = 'block';
                $(window).scrollTop(doc);
            }
        } else if (sub === '-') {
            if (desktop) {
                doc = document.getElementById(abrirJanela[i].substring(1, abrirJanela[i].length));
                doc.style.display = 'block';
                $(window).scrollTop(doc);
            }
        } else {
            doc = document.getElementById(abrirJanela[i]);
            doc.style.display = 'block';
            if (!reset) {
                $(window).scrollTop(doc);
            }
        }
    }

    fecharLoading();
}
