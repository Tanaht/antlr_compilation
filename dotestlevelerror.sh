export CLASSPATH=.:./src:./antlr-3.5.2-complete.jar


for i in tests/testlevelerror/*.vsl ; do
	echo -e "$i"
	file=$(echo $i | sed -e "s/vsl/comp_out/g")
	result_string=`cat $file`
	result_string=$(echo $result_string)
	echo $result_string
	java VslComp $i > ./nachos/test/output.s
	
	

	#var2=$(echo $var | sed -e "s/ Machine halting Cleaning up...//g")
	#var2=$(echo $var2 | sed -e "s/Machine halting Cleaning up...//g")
	
	#echo $var2
	#if [[ "$result_string" == "$var2" ]]; then
	#	echo -e "$i \n Good\n"
	#else
	#	echo -e "$i \n bad\n"
#
	#fi
	
	
done




