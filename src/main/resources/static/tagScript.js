function toggleTag(checkbox) {
    const selectedTagsContainer = document.getElementById('selected-tags');
    if (checkbox.checked) {
        const tagElement = document.createElement('div');
        tagElement.className = 'selected-tag';
        tagElement.setAttribute('data-tag-id', checkbox.value);
        tagElement.innerHTML = `
            <span>${checkbox.parentElement.querySelector('.label-text').textContent}</span>
            <button type="button" onclick="removeTag(this)">x</button>
        `;
        selectedTagsContainer.appendChild(tagElement);
    } else {
        const tagElement = selectedTagsContainer.querySelector(`[data-tag-id="${checkbox.value}"]`);
        if (tagElement) {
            selectedTagsContainer.removeChild(tagElement);
        }
    }
}

function removeTag(button) {
    const tagElement = button.parentElement;
    const tagId = tagElement.getAttribute('data-tag-id');
    const checkbox = document.querySelector(`input[type="checkbox"][value="${tagId}"]`);
    if (checkbox) {
        checkbox.checked = false;
    }
    tagElement.remove();
}

function clearSelectedTags() {
    const selectedTagsContainer = document.getElementById('selected-tags');
    selectedTagsContainer.innerHTML = '';
    const checkboxes = document.querySelectorAll('input[type="checkbox"][name="tagIds"]');
    checkboxes.forEach(checkbox => {
        checkbox.checked = false;
    });
}
