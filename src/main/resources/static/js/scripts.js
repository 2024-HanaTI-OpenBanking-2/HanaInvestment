function loadBalances() {
  fetch('/balances')
  .then(response => response.json())
  .then(data => {
    console.log(data)
    const balancesDiv = document.getElementById('balances');
    balancesDiv.innerHTML = ''; // Clear previous content
    data.forEach(balance => {
      const balanceDiv = document.createElement('div');
      balanceDiv.innerHTML = `
        <p>Product Name: ${balance.stockName || 'N/A'}</p>
        <p>Current Quantity: ${balance.currentQuantity}</p>
        <p>Purchase Price: ${balance.purchasePrice}</p>
        <p>Fluctuation Rate: ${balance.fluctuationRate}</p>
        <p>Evaluation Profit/Loss: ${balance.evaluationProfitLoss}</p>
        <p>Stock Code: ${balance.stockCode}</p>
      `;
      balanceDiv.classList.add('balance-item'); // Add CSS class for styling
      balancesDiv.appendChild(balanceDiv);
    });
  })
  .catch(error => {
    console.error('Error loading balances:', error);
    balancesDiv.innerHTML = '<p>Error loading data.</p>'; // Display error message
  });
}
