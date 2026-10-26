import pdfplumber
p = r'C:\Users\hp\Downloads\Lab 6_Navigation_Fragments.pdf'
d = pdfplumber.open(p)
for i in range(8,15):
    print(f'--- PAGE {i+1} ---')
    print(d.pages[i].extract_text() or '')
