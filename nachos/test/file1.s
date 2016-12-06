.rdata
.align 2
$LC0:
       .ascii	"%d\000"
       .align 2
L10:
       .ascii	"\012 Entrer le\000"
       .align 2
L11:
       .ascii	"eme:  \000"
       .align 2
L12:
       .ascii	"   i=\000"
       .align 2
L13:
       .ascii	"  j=\000"
       .align 2
L16:
       .ascii	"\012 t[\000"
       .align 2
L17:
       .ascii	"] = \000"
.text
# label main
# beginfunc 
	.align	2
	.globl main
	.ent main
main:
	 addiu	$sp,$sp,-124
	 sw	$31,16($29)
	 sw	$16,24($29)
	 sw	$17,28($29)
	 sw	$18,32($29)
	 sw	$19,36($29)
	 sw	$20,40($29)
	 sw	$21,44($29)
	 sw	$22,48($29)
	 sw	$23,52($29)
# var a
# var i
# var j
# i = 0
       li   $8, 0
# label L14
       sw  $8,96($29)
L14:
# var T_0
# T_0 = 10 - i
       li   $9, 10
       lw  $8,96($29)
	sub $8, $9, $8
# ifz T_0 goto L15
       sw  $8,104($29)
	beq  $8,0,L15
# arg L10
       lui   $10,%hi(L10)
       addiu   $10,$10,%lo(L10)
	 sw   $10,0($29)
	move   $4,$10
# call L4
	 jal   n_printf
	 nop
# arg i
       lw  $8,96($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L11
       lui   $8,%hi(L11)
       addiu   $8,$8,%lo(L11)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# j =  call L8
       addiu   $5,$29,100
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_read_int
	 nop
       sw   $2,100($29)
# a [ i ] = j
       lw  $8,96($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       add   $9,$29,56
       add   $8,$8,$9
       move  $9,$2
       sw  $9,0($8)
# var T_1
# T_1 = i + 1
       lw  $10,96($29)
       li   $8, 1
	add $8, $10, $8
# i = T_1
       sw  $8,108($29)
# arg L12
       lui   $10,%hi(L12)
       addiu   $10,$10,%lo(L12)
	 sw   $10,0($29)
	move   $4,$10
# call L4
       sw  $2,100($29)
       sw  $8,96($29)
       sw  $9,100($29)
	 jal   n_printf
	 nop
# arg i
       lw  $8,96($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L13
       lui   $8,%hi(L13)
       addiu   $8,$8,%lo(L13)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# arg j
       lw  $8,100($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# goto L14
	j  L14
# label L15
L15:
# arg a
	 add   $8,$29,56
	 sw   $8,0($29)
	move   $4,$8
# arg 10
       li   $8, 10
	 sw   $8,4($29)
	move   $5,$8
# call heapsort
	 jal   heapsort
	 nop
# i = 0
       li   $8, 0
# label L18
       sw  $8,96($29)
L18:
# var T_2
# T_2 = 10 - i
       li   $9, 10
       lw  $8,96($29)
	sub $8, $9, $8
# ifz T_2 goto L19
       sw  $8,112($29)
	beq  $8,0,L19
# arg L16
       lui   $10,%hi(L16)
       addiu   $10,$10,%lo(L16)
	 sw   $10,0($29)
	move   $4,$10
# call L4
	 jal   n_printf
	 nop
# arg i
       lw  $8,96($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L17
       lui   $8,%hi(L17)
       addiu   $8,$8,%lo(L17)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# var T_3
# T_3 = a [ i ]
       lw  $8,96($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       add   $9,$29,56
       add   $8,$8,$9
       lw  $8,0($8)
# arg T_3
       sw  $8,116($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# var T_4
# T_4 = i + 1
       lw  $9,96($29)
       li   $8, 1
	add $8, $9, $8
# i = T_4
       sw  $8,120($29)
# goto L18
       sw  $8,96($29)
	j  L18
# label L19
L19:
# endfunc 
	 lw	$16,20($29)
	 lw	$17,24($29)
	 lw	$18,28($29)
	 lw	$19,32($29)
	 lw	$20,36($29)
	 lw	$21,40($29)
	 lw	$22,44($29)
	 lw	$23,48($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,124
	 jr  $31
	 nop
	.end main
# label heapsort
# beginfunc 
	.align	2
	.globl heapsort
	.ent heapsort
heapsort:
	 addiu	$sp,$sp,-156
	 sw	$31,16($29)
# var t
# var n
# var l
# var r
# var j
# var s
# var test
# var T_5
# T_5 = n / 2
       lw  $9,160($29)
       li   $8, 2
       sw  $8,44($29)
	div $9, $8
	mflo $8
# var T_6
# T_6 = T_5 + 1
       li   $9, 1
	add $9, $8, $9
# l = T_6
       sw  $9,48($29)
# r = n
       lw  $10,160($29)
# label L31
       sw  $8,44($29)
       sw  $9,24($29)
       sw  $10,28($29)
L31:
# var T_7
# arg r
       lw  $8,28($29)
	 sw   $8,0($29)
	move   $4,$8
# arg 2
       li   $9, 2
	 sw   $9,4($29)
	move   $5,$9
# T_7 =  call plusgrand
	 jal   plusgrand
	 nop
# ifz T_7 goto L32
       sw  $2,52($29)
       move  $8,$2
	beq  $8,0,L32
# var T_8
# arg l
       lw  $9,24($29)
	 sw   $9,0($29)
	move   $4,$9
# arg 1
       li   $10, 1
	 sw   $10,4($29)
	move   $5,$10
# T_8 =  call plusgrandstrict
	 jal   plusgrandstrict
	 nop
# ifz T_8 goto L22
       sw  $2,56($29)
       move  $8,$2
	beq  $8,0,L22
# var T_9
# T_9 = l - 1
       lw  $10,24($29)
       li   $9, 1
	sub $9, $10, $9
# l = T_9
       sw  $9,60($29)
# j = l
       sw  $9,24($29)
# goto L20
       sw  $9,32($29)
	j  L20
# label L22
L22:
# var ex
# var T_10
# T_10 = t [ 0 ]
       li   $8, 0
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,156($29)
       add   $8,$8,$9
       lw  $8,0($8)
# ex = T_10
       sw  $8,68($29)
# var T_12
# T_12 = t [ T_11 ]
       lw  $10,0($29)
       li   $11,4
       mult   $10,$11
       mflo   $10
       add   $10,$10,$9
       lw  $10,0($10)
# t [ 0 ] = T_12
       li   $11, 0
       li   $12,4
       mult   $11,$12
       mflo   $11
       add   $11,$11,$9
       sw  $10,0($11)
# var T_13
# T_13 = r - 1
       lw  $12,28($29)
       li   $11, 1
	sub $11, $12, $11
# t [ T_13 ] = ex
       sw  $11,76($29)
       li   $13,4
       mult   $11,$13
       mflo   $11
       add   $11,$11,$9
       sw  $8,0($11)
# var T_14
# T_14 = r - 1
       li   $11, 1
	sub $11, $12, $11
# r = T_14
       sw  $11,80($29)
# j = 1
       li   $12, 1
# label L20
       sw  $8,64($29)
       sw  $10,72($29)
       sw  $11,28($29)
       sw  $12,32($29)
L20:
# var T_16
# T_16 = t [ T_15 ]
       lw  $8,0($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,156($29)
       add   $8,$8,$9
       lw  $8,0($8)
# s = T_16
       sw  $8,84($29)
# var T_17
# arg r
       lw  $10,28($29)
	 sw   $10,0($29)
	move   $4,$10
# var T_18
# T_18 = 2 * j
       li   $12, 2
       lw  $11,32($29)
	mult $12, $11
	mflo $11
# arg T_18
       sw  $11,92($29)
	 sw   $11,4($29)
	move   $5,$11
# T_17 =  call plusgrand
       sw  $8,36($29)
	 jal   plusgrand
	 nop
# test = T_17
       move  $8,$2
# label L29
       sw  $2,88($29)
       sw  $8,40($29)
L29:
# ifz test goto L30
       lw  $8,40($29)
	beq  $8,0,L30
# var k
# var T_19
# T_19 = 2 * j
       li   $10, 2
       lw  $9,32($29)
	mult $10, $9
	mflo $9
# k = T_19
       sw  $9,100($29)
# var T_20
# arg r
       lw  $11,28($29)
	 sw   $11,0($29)
	move   $4,$11
# arg k
       sw  $9,96($29)
	 sw   $9,4($29)
	move   $5,$9
# T_20 =  call plusgrandstrict
	 jal   plusgrandstrict
	 nop
# var T_21
# var T_22
# T_22 = t [ k ]
       lw  $8,96($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,156($29)
       add   $8,$8,$9
       lw  $8,0($8)
# arg T_22
       sw  $8,112($29)
	 sw   $8,0($29)
	move   $4,$8
# var T_24
# T_24 = t [ T_23 ]
       lw  $10,0($29)
       li   $11,4
       mult   $10,$11
       mflo   $10
       add   $10,$10,$9
       lw  $10,0($10)
# arg T_24
       sw  $10,116($29)
	 sw   $10,4($29)
	move   $5,$10
# T_21 =  call plusgrandstrict
       sw  $2,104($29)
	 jal   plusgrandstrict
	 nop
# var T_25
# T_25 = T_20 * T_21
       lw  $9,104($29)
       move  $8,$2
	mult $9, $8
	mflo $8
# ifz T_25 goto L25
       sw  $2,108($29)
       sw  $8,120($29)
	beq  $8,0,L25
# var T_26
# T_26 = k + 1
       lw  $11,96($29)
       li   $10, 1
	add $10, $11, $10
# k = T_26
       sw  $10,124($29)
# goto L23
       sw  $10,96($29)
	j  L23
# label L25
L25:
# label L23
L23:
# var T_27
# var T_29
# T_29 = t [ T_28 ]
       lw  $8,0($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,156($29)
       add   $8,$8,$9
       lw  $8,0($8)
# arg T_29
       sw  $8,132($29)
	 sw   $8,0($29)
	move   $4,$8
# arg s
       lw  $10,36($29)
	 sw   $10,4($29)
	move   $5,$10
# T_27 =  call plusgrandstrict
	 jal   plusgrandstrict
	 nop
# ifz T_27 goto L28
       sw  $2,128($29)
       move  $8,$2
	beq  $8,0,L28
# var T_32
# T_32 = j - 1
       lw  $10,32($29)
       li   $9, 1
	sub $9, $10, $9
# var T_31
# T_31 = t [ T_30 ]
       lw  $11,0($29)
       li   $12,4
       mult   $11,$12
       mflo   $11
       lw  $12,156($29)
       add   $11,$11,$12
       lw  $11,0($11)
# t [ T_32 ] = T_31
       sw  $9,136($29)
       li   $13,4
       mult   $9,$13
       mflo   $9
       add   $9,$9,$12
       sw  $11,0($9)
# j = k
       lw  $9,96($29)
# var T_33
# arg r
       lw  $10,28($29)
	 sw   $10,0($29)
	move   $4,$10
# var T_34
# T_34 = 2 * j
       li   $13, 2
	mult $13, $9
	mflo $13
# arg T_34
       sw  $13,148($29)
	 sw   $13,4($29)
	move   $5,$13
# T_33 =  call plusgrand
       sw  $9,32($29)
       sw  $11,140($29)
	 jal   plusgrand
	 nop
# test = T_33
       move  $8,$2
# goto L26
       sw  $2,144($29)
       sw  $8,40($29)
	j  L26
# label L28
L28:
# test = 0
       li   $8, 0
# label L26
       sw  $8,40($29)
L26:
# goto L29
	j  L29
# label L30
L30:
# var T_35
# T_35 = j - 1
       lw  $9,32($29)
       li   $8, 1
	sub $8, $9, $8
# t [ T_35 ] = s
       sw  $8,152($29)
       li   $10,4
       mult   $8,$10
       mflo   $8
       lw  $10,156($29)
       add   $8,$8,$10
       lw  $11,36($29)
       sw  $11,0($8)
# goto L31
	j  L31
# label L32
L32:
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,156
	 jr  $31
	 nop
	.end heapsort
# label plusgrandstrict
# beginfunc 
	.align	2
	.globl plusgrandstrict
	.ent plusgrandstrict
plusgrandstrict:
	 addiu	$sp,$sp,-52
	 sw	$31,16($29)
# var n
# var m
# var continue
# var nn
# var mm
# var T_36
# T_36 = n * m
       lw  $9,52($29)
       lw  $8,56($29)
	mult $9, $8
	mflo $8
# continue = T_36
       sw  $8,36($29)
# nn = n
# mm = m
       lw  $10,56($29)
# label L33
       sw  $8,24($29)
       sw  $9,28($29)
       sw  $10,32($29)
L33:
# ifz continue goto L34
       lw  $8,24($29)
	beq  $8,0,L34
# var T_37
# T_37 = mm - 1
       lw  $10,32($29)
       li   $9, 1
	sub $9, $10, $9
# mm = T_37
       sw  $9,40($29)
# var T_38
# T_38 = nn - 1
       lw  $11,28($29)
       li   $10, 1
	sub $10, $11, $10
# nn = T_38
       sw  $10,44($29)
# var T_39
# T_39 = nn * mm
	mult $10, $9
	mflo $11
# continue = T_39
       sw  $11,48($29)
# goto L33
       sw  $9,32($29)
       sw  $10,28($29)
       sw  $11,24($29)
	j  L33
# label L34
L34:
# ifz nn goto L37
       lw  $8,28($29)
	beq  $8,0,L37
# return 1
       li   $2, 1
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# goto L35
	j  L35
# label L37
L37:
# return 0
       li   $2, 0
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# label L35
L35:
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
	.end plusgrandstrict
# label plusgrand
# beginfunc 
	.align	2
	.globl plusgrand
	.ent plusgrand
plusgrand:
	 addiu	$sp,$sp,-52
	 sw	$31,16($29)
# var n
# var m
# var continue
# var nn
# var mm
# var T_40
# T_40 = n * m
       lw  $9,52($29)
       lw  $8,56($29)
	mult $9, $8
	mflo $8
# continue = T_40
       sw  $8,36($29)
# nn = n
# mm = m
       lw  $10,56($29)
# label L38
       sw  $8,24($29)
       sw  $9,28($29)
       sw  $10,32($29)
L38:
# ifz continue goto L39
       lw  $8,24($29)
	beq  $8,0,L39
# var T_41
# T_41 = mm - 1
       lw  $10,32($29)
       li   $9, 1
	sub $9, $10, $9
# mm = T_41
       sw  $9,40($29)
# var T_42
# T_42 = nn - 1
       lw  $11,28($29)
       li   $10, 1
	sub $10, $11, $10
# nn = T_42
       sw  $10,44($29)
# var T_43
# T_43 = nn * mm
	mult $10, $9
	mflo $11
# continue = T_43
       sw  $11,48($29)
# goto L38
       sw  $9,32($29)
       sw  $10,28($29)
       sw  $11,24($29)
	j  L38
# label L39
L39:
# ifz nn goto L42
       lw  $8,28($29)
	beq  $8,0,L42
# return 1
       li   $2, 1
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# goto L40
	j  L40
# label L42
L42:
# ifz mm goto L45
       lw  $8,32($29)
	beq  $8,0,L45
# return 0
       li   $2, 0
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# goto L43
	j  L43
# label L45
L45:
# return 1
       li   $2, 1
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# label L43
L43:
# label L40
L40:
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
	.end plusgrand
