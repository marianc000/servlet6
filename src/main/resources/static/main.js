console.log(out)
for (let i = 0; i < 100; i++) {
    fetch('myservlet').then(r => r.text())
            .then(t => {
                t=t.split("\n").filter((l,i)=>[0,4].includes(i)).join('\n');
                out.insertAdjacentHTML('afterbegin', `<pre>${t}</pre>`);
            });
}


