document.addEventListener("DOMContentLoaded", function () {
    document.getElementById('tagForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const form = event.target;
        const data = new FormData(form);
        fetch(form.action, {
            method: 'POST',
            body: data
        }).then(response => {
            if (response.ok) {
                document.getElementById('tagModal').close();
                location.reload(); // 페이지를 새로 고쳐서 새로운 태그를 로드
            } else {
                alert('태그 생성에 실패했습니다.');
            }
        }).catch(error => {
            console.error('태그 생성 중 오류 발생:', error);
            alert('태그 생성 중 오류가 발생했습니다.');
        });
    });
});
