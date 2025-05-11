// Add any necessary JavaScript functionality here
document.addEventListener('DOMContentLoaded', function() {
    // Example: Add click handlers for buttons
    const buttons = document.querySelectorAll('.btn-primary');
    buttons.forEach(button => {
        button.addEventListener('click', function(e) {
            if (e.target.textContent === 'Create New Assignment' ||
                e.target.textContent === 'Create New Event') {
                // Handle creation of new items
                console.log('Create new item clicked');
            }
        });
    });
});
