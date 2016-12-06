export CLASSPATH=.:./src:./antlr-3.5.2-complete.jar


for i in tests/testlevel4/*.vsl ; do
	java VslComp $i > ./nachos/test/output.s
	cd nachos
	./asm2bin.sh output
	input=$(echo $i | sed -e "s/vsl/test_in/g")
	if [ -f "../$input" ]; then
		var=`./exec.sh output < "../$input"`
	else
		var=`./exec.sh output`
		
	fi
	cd ..
	file=$(echo $i | sed -e "s/vsl/mips_out/g")
	result_string=`cat $file`

	var2=$(echo $var | sed -e "s/ Machine halting Cleaning up...//g")
	var2=$(echo $var2 | sed -e "s/Machine halting Cleaning up...//g")
	result_string=$(echo $result_string)
	if [[ "$result_string" == "$var2" ]]; then
		echo -e "$i \n Good\n"
	else
		echo -e "$i \n bad\n"
		echo $var2 > temp1
		echo $result_string >temp2
	fi
	
	
done




