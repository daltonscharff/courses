# Money on my Mind, and my mind on my REST API -- Dalton Scharff

Name: Dalton Scharff

Pitt ID: das227

## Installation


1. Clone the following repository: https://github.com/w8s-class/201801-money-on-my-mind-and-my-mind-on-my-rest-api-daltonscharff.git
1. Navigate to the repo folder
1. Install VirtualENV
1. Create new environment using Python 3.6
1. Initialize the virtual environment
1. Run **pip install -r requirements.txt** to install the necessary dependencies

## Running the App

1. Run **export FLASK_APP=budget.py** to set the Flask variable
1. Run **flask run** to run the project
1. Navigate to **localhost:5000** to view the website

## Notes:

* As per the specifications, the list of all purchases is not show, but can be accessed using a get call to **localhost:5000/purchases** and only purchases during the current month and year are calculated into the remaining budget.
* Remaining values that are negative mean that you have overspent your budget for that category.
