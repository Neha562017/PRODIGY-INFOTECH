pip install beautifulsoup4
 

import requests
from bs4 import BeautifulSoup
import csv

# URL of the Amazon Best Sellers page for a specific category
url = "https://www.amazon.com/Best-Sellers-Electronics/zgbs/electronics"

response = requests.get(url)
soup = BeautifulSoup(response.content, "html.parser")

product_data = []

# Find all product items on the page
product_items = soup.find_all("div", class_="zg-item-immersion")

for item in product_items:
    product_name = item.find("div", class_="p13n-sc-truncate").text.strip()
    
    price_tag = item.find("span", class_="p13n-sc-price")
    product_price = price_tag.text.strip() if price_tag else "N/A"
    
    rating_tag = item.find("span", class_="a-icon-alt")
    product_rating = rating_tag.text.strip() if rating_tag else "N/A"
    
    product_data.append((product_name, product_price, product_rating))

# Save the scraped data to a CSV file
csv_filename = "amazon_products.csv"

with open(csv_filename, "w", newline="", encoding="utf-8") as csvfile:
    csv_writer = csv.writer(csvfile)
    csv_writer.writerow(["Product Name", "Price", "Rating"])
    csv_writer.writerows(product_data)

print(f"Scraped data saved to {csv_filename}")
