const questions = [
  {
    question: "What is the capital of India?",
    options: ["Mumbai", "New Delhi", "Bangalore", "Kolkata"],
    answer: "New Delhi"
  },
  {
    question: "Which language runs in a web browser?",
    options: ["Python", "Java", "C", "JavaScript"],
    answer: "JavaScript"
  },
  {
    question: "What does CSS stand for?",
    options: ["Central Style Sheets", "Cascading Style Sheets", "Control Style Sheets", "None"],
    answer: "Cascading Style Sheets"
  }
];

let currentIndex = 0;
let score = 0;
let selectedOption = "";

function startQuiz() {
  document.getElementById("start-screen").style.display = "none";
  document.getElementById("quiz-screen").style.display = "block";
  showQuestion();
}

function showQuestion() {
  const currentQ = questions[currentIndex];
  document.getElementById("question-text").innerText = currentQ.question;

  const optionsBox = document.getElementById("options-box");
  optionsBox.innerHTML = "";

  currentQ.options.forEach(option => {
    const div = document.createElement("div");
    div.className = "option";
    div.innerText = option;
    div.onclick = () => selectOption(div, option);
    optionsBox.appendChild(div);
  });

  document.getElementById("feedback").innerText = "";
}

function selectOption(element, optionText) {
  const allOptions = document.querySelectorAll(".option");
  allOptions.forEach(el => el.classList.remove("selected"));

  element.classList.add("selected");
  selectedOption = optionText;
}

function submitAnswer() {
  if (!selectedOption) {
    document.getElementById("feedback").innerText = "❌ Please select an option!";
    return;
  }

  const correct = questions[currentIndex].answer;
  if (selectedOption === correct) {
    score++;
    document.getElementById("feedback").innerText = "✅ Correct!";
  } else {
    document.getElementById("feedback").innerText = `❌ Wrong! Correct: ${correct}`;
  }

  // Wait and go to next
  setTimeout(() => {
    currentIndex++;
    selectedOption = "";
    if (currentIndex < questions.length) {
      showQuestion();
    } else {
      showResult();
    }
  }, 1200);
}

function showResult() {
  document.getElementById("quiz-screen").style.display = "none";
  document.getElementById("result-screen").style.display = "block";
  document.getElementById("final-score").innerText = `Your Score: ${score} / ${questions.length}`;
}

function restartQuiz() {
  currentIndex = 0;
  score = 0;
  selectedOption = "";
  document.getElementById("result-screen").style.display = "none";
  startQuiz();
}
