.rdata
.align 2
$LC0:
       .ascii	"%d\000"
       .align 2
L10:
       .ascii	"\012 Entrer le \000"
       .align 2
L11:
       .ascii	"eme:  \000"
       .align 2
L14:
       .ascii	"\012 t[\000"
       .align 2
L15:
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
# label L12
       sw  $8,96($29)
L12:
# var T_0
# T_0 = 10 - i
       li   $9, 10
       lw  $8,96($29)
	sub $8, $9, $8
# ifz T_0 goto L13
       sw  $8,104($29)
	beq  $8,0,L13
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
# goto L12
       sw  $2,100($29)
       sw  $8,96($29)
       sw  $9,100($29)
	j  L12
# label L13
L13:
# arg a
	 add   $8,$29,56
	 sw   $8,0($29)
	move   $4,$8
# arg 9
       li   $8, 9
	 sw   $8,4($29)
	move   $5,$8
# call naivesort
	 jal   naivesort
	 nop
# i = 0
       li   $8, 0
# label L16
       sw  $8,96($29)
L16:
# var T_2
# T_2 = 10 - i
       li   $9, 10
       lw  $8,96($29)
	sub $8, $9, $8
# ifz T_2 goto L17
       sw  $8,112($29)
	beq  $8,0,L17
# arg L14
       lui   $10,%hi(L14)
       addiu   $10,$10,%lo(L14)
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
# arg L15
       lui   $8,%hi(L15)
       addiu   $8,$8,%lo(L15)
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
# goto L16
       sw  $8,96($29)
	j  L16
# label L17
L17:
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
# label naivesort
# beginfunc 
	.align	2
	.globl naivesort
	.ent naivesort
naivesort:
	 addiu	$sp,$sp,-68
	 sw	$31,16($29)
# var t
# var index
# var max
# var maxpos
# var i
# ifz index goto L25
       lw  $8,72($29)
	beq  $8,0,L25
# var T_5
# T_5 = t [ index ]
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,68($29)
       add   $8,$8,$9
       lw  $8,0($8)
# max = T_5
       sw  $8,36($29)
# i = index
       lw  $10,72($29)
# maxpos = index
       lw  $11,72($29)
# label L21
       sw  $8,24($29)
       sw  $10,32($29)
       sw  $11,28($29)
L21:
# var T_6
# T_6 = i + 1
       lw  $9,32($29)
       li   $8, 1
	add $8, $9, $8
# ifz T_6 goto L22
       sw  $8,40($29)
	beq  $8,0,L22
# var T_7
# var T_8
# T_8 = t [ i ]
       li   $10,4
       mult   $9,$10
       mflo   $9
       lw  $10,68($29)
       add   $9,$9,$10
       lw  $9,0($9)
# arg T_8
       sw  $9,48($29)
	 sw   $9,0($29)
	move   $4,$9
# arg max
       lw  $11,24($29)
	 sw   $11,4($29)
	move   $5,$11
# T_7 =  call plusgrandstrict
	 jal   plusgrandstrict
	 nop
# ifz T_7 goto L20
       sw  $2,44($29)
       move  $8,$2
	beq  $8,0,L20
# var T_9
# T_9 = t [ i ]
       lw  $9,32($29)
       li   $10,4
       mult   $9,$10
       mflo   $9
       lw  $10,68($29)
       add   $9,$9,$10
       lw  $9,0($9)
# max = T_9
       sw  $9,52($29)
# maxpos = i
       lw  $11,32($29)
# goto L18
       sw  $9,24($29)
       sw  $11,28($29)
	j  L18
# label L20
L20:
# label L18
L18:
# var T_10
# T_10 = i - 1
       lw  $9,32($29)
       li   $8, 1
	sub $8, $9, $8
# i = T_10
       sw  $8,56($29)
# goto L21
       sw  $8,32($29)
	j  L21
# label L22
L22:
# var T_11
# T_11 = t [ index ]
       lw  $8,72($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,68($29)
       add   $8,$8,$9
       lw  $8,0($8)
# t [ maxpos ] = T_11
       lw  $10,28($29)
       li   $11,4
       mult   $10,$11
       mflo   $10
       add   $10,$10,$9
       sw  $8,0($10)
# t [ index ] = max
       lw  $10,72($29)
       li   $11,4
       mult   $10,$11
       mflo   $10
       add   $10,$10,$9
       lw  $11,24($29)
       sw  $11,0($10)
# arg t
	 sw   $9,0($29)
	move   $4,$9
# var T_12
# T_12 = index - 1
       lw  $12,72($29)
       li   $10, 1
	sub $10, $12, $10
# arg T_12
       sw  $10,64($29)
	 sw   $10,4($29)
	move   $5,$10
# call naivesort
       sw  $8,60($29)
	 jal   naivesort
	 nop
# goto L23
	j  L23
# label L25
L25:
# label L23
L23:
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,68
	 jr  $31
	 nop
	.end naivesort
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
# var T_13
# T_13 = n * m
       lw  $9,52($29)
       lw  $8,56($29)
	mult $9, $8
	mflo $8
# continue = T_13
       sw  $8,36($29)
# nn = n
# mm = m
       lw  $10,56($29)
# label L26
       sw  $8,24($29)
       sw  $9,28($29)
       sw  $10,32($29)
L26:
# ifz continue goto L27
       lw  $8,24($29)
	beq  $8,0,L27
# var T_14
# T_14 = mm - 1
       lw  $10,32($29)
       li   $9, 1
	sub $9, $10, $9
# mm = T_14
       sw  $9,40($29)
# var T_15
# T_15 = nn - 1
       lw  $11,28($29)
       li   $10, 1
	sub $10, $11, $10
# nn = T_15
       sw  $10,44($29)
# var T_16
# T_16 = nn * mm
	mult $10, $9
	mflo $11
# continue = T_16
       sw  $11,48($29)
# goto L26
       sw  $9,32($29)
       sw  $10,28($29)
       sw  $11,24($29)
	j  L26
# label L27
L27:
# ifz nn goto L30
       lw  $8,28($29)
	beq  $8,0,L30
# return 1
       li   $2, 1
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# goto L28
	j  L28
# label L30
L30:
# return 0
       li   $2, 0
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
# label L28
L28:
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,52
	 jr  $31
	 nop
	.end plusgrandstrict
