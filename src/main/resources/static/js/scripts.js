function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = 'rgba(';
  for (var i = 0; i < 3; i++) {
    color += Math.floor(Math.random() * 256) + ', ';
  }
  return color + '0.5)';
}

function loadBalances() {
  fetch('/balances')
  .then(response => response.json())
  .then(data => {
    const balancesDiv = document.getElementById('balances');
    balancesDiv.innerHTML = '';
    data.forEach(balance => {
      const balanceDiv = document.createElement('div');
      balanceDiv.className = 'balance-item';
      const isNegative = balance.evaluationProfitLoss < 0;
      const valueClass = isNegative ? 'negative-value' : 'positive-value';

      balanceDiv.innerHTML = `
          <div class="balance-item-title">${balance.stockName || 'N/A'}</div>
          <div class="balance-item-details">
            <p><strong>구분:</strong> 매도가능</p>
            <p><strong>보유량:</strong> ${balance.currentQuantity}</p>
            <p><strong>손익율:</strong> <span class="${valueClass}">${balance.fluctuationRate}%</span></p>
            <p><strong>평가손익:</strong> <span class="${valueClass}">${balance.evaluationProfitLoss}</span></p>
          </div>
        `;
      balancesDiv.appendChild(balanceDiv);
    });
    // 애니메이션 효과 적용
    setTimeout(() => {
      balancesDiv.classList.add('animated', 'fadeIn');
    })
    balancesDiv.style.display = 'block';
    balancesDiv.style.opacity = '1';
    balancesDiv.style.transform = 'translateY(0)';
  })
  .catch(error => {
    console.error('Error loading balances:', error);
    balancesDiv.innerHTML = '<p>Error loading data.</p>';
    balancesDiv.style.display = 'block';
    balancesDiv.style.opacity = '1';
    balancesDiv.style.transform = 'translateY(0)';
  });
}


function loadChart() {
  fetch('/balances')
  .then(response => response.json())
  .then(data => {
    const ctx = document.getElementById('stockChart').getContext('2d');
    const stockNames = data.map(item => item.stockName || 'N/A');
    const currentQuantities = data.map(item => item.currentQuantity);
    const backgroundColors = currentQuantities.map(() => getRandomColor());

    new Chart(ctx, {
      type: 'bar', // 차트 유형을 바(bar)로 설정
      data: {
        labels: stockNames,
        datasets: [{
          label: 'Current Quantity',
          data: currentQuantities,
          backgroundColor: backgroundColors,
          borderColor: 'rgba(0,0,0,0.1)',
          borderWidth: 1
        }]
      },
      options: {
        responsive: false,
        maintainAspectRatio: false,
        animation: {
          duration: 1000,
          easing: 'easeOutBounce',
          onComplete: function() {
            console.log('Animation completed!');
          }
        },
        scales: {
          y: {
            beginAtZero: true // Y축을 0부터 시작하도록 설정
          }
        },
        plugins: {
          datalabels: {
            color: '#000000',
            font: {
              weight: 'bold',
              size: 14
            },
            formatter: (value, context) => {
              return context.chart.data.labels[context.dataIndex] + ': ' + value;
            }
          },
          legend: {
            position: 'top'
          },
          tooltip: {
            callbacks: {
              label: function(context) {
                return `${context.label}: ${context.raw}`;
              }
            }
          }
        }
      }
    });
  })
  .catch(error => console.error('Error loading chart data:', error));
}

document.addEventListener('DOMContentLoaded', function() {
  loadChart(); // 페이지 로드 시 차트 로드
  const loadButton = document.getElementById('loadBalancesButton');
  loadButton.addEventListener('click', loadBalances); // 버튼 클릭 시 텍스트 정보 로드
});