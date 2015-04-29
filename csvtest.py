import csv

i = 0
with open('book_loans.csv', 'r') as f:
	reader = csv.reader(f, delimiter='\t', quoting=csv.QUOTE_NONE)
	for row in reader:
		i+=1
		#if len(row[0]) != 10:
			#print row[0],len(row[0])

		#print "here",int(row[0])
		if i>1:
			if int(row[0]) > 15:	
				print "insert into Book_Loans(Book_id, Branch_id, Card_no, Date_out, Due_Date, Date_in) values('"+row[1]+"','"+row[2]+"','"+row[3]+"','"+row[4]+"','"+row[5]+"','"+row[6]+"');"
			else:
				print "insert into Book_Loans(Book_id, Branch_id, Card_no, Date_out, Due_Date, Date_in) values('"+row[1]+"','"+row[2]+"','"+row[3]+"','"+row[4]+"','"+row[5]+"',"+row[6]+");"


		'''if "various" == row[1].strip().lower():
			print "insert into Book_Authors values('"+row[0]+"','"+row[1].strip()+"','"+"2');"
		elif "the beatles" == row[1].strip().lower():
			print "insert into Book_Authors values('"+row[0]+"','"+row[1].strip()+"','"+"2');"
		elif "," in row[1]:
			for each in row[1].split(","):
				print "insert into Book_Authors values('"+row[0]+"','"+each.strip()+"','"+"1');"
		else:
			print "insert into Book_Authors values('"+row[0]+"','"+row[1].strip()+"','"+"1');"'''


		'''for row in reader:'''
		'''bookname = row[2].replace("'","\\'")'''
		'''print "insert into Book values('"+row[0]+"','"+bookname+"');"'''


		#print "insert into Book_Copies values('"+row[0]+"','"+row[1]+"','"+row[2]+"');"

	#print i